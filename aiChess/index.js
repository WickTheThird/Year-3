import * as THREE from "../node_modules/three/build/three.module.js";

let scene, camera, renderer;
const tileSize = 1;
const board = [];

let moveForward = false;
let moveBackward = false;
let moveLeft = false;
let moveRight = false;

let isMouseDown = false;
let mouseX = 0;
let mouseY = 0;

function init() {
  scene = new THREE.Scene();
  camera = new THREE.PerspectiveCamera(
    75,
    window.innerWidth / window.innerHeight,
    0.1,
    1000
  );

  renderer = new THREE.WebGLRenderer();
  renderer.setSize(window.innerWidth, window.innerHeight);
  document.body.appendChild(renderer.domElement);

  camera.position.z = 5;
}

function loadModel() {
  const loader = new THREE.GLTFLoader();
  loader.load("/uploads/bumbuf2/vr_gallery.glb", function (gltf) {
    const model = gltf.scene;
    scene.add(model);
  });
}

// function createChessBoard() {
//  for (let x = 0; x < 8; x++) {
//   for (let y = 0; y < 8; y++) {
//      const geometry = new THREE.BoxGeometry(tileSize, tileSize, tileSize);
//      const material = new THREE.MeshBasicMaterial({
//       color: (x + y) % 2 === 0 ? 0xffffff : 0x808080,
//      });
//      const cube = new THREE.Mesh(geometry, material);
//      cube.position.set((y - 3.5) * tileSize, (x - 3.5) * tileSize, 0);
//      scene.add(cube);
//      board.push(cube);
//   }
//  }
// }

function animate() {
  requestAnimationFrame(animate);
  resizeRendererToDisplaySize();

  if (moveForward) {
    camera.translateZ(-1);
  }
  if (moveBackward) {
    camera.translateZ(1);
  }
  if (moveLeft) {
    camera.translateX(-1);
  }
  if (moveRight) {
    camera.translateX(1);
  }

  renderer.render(scene, camera);
}

function resizeRendererToDisplaySize() {
  const canvas = renderer.domElement;
  const width = canvas.clientWidth;
  const height = canvas.clientHeight;
  const needResize = canvas.width !== width || canvas.height !== height;
  if (needResize) {
    renderer.setSize(width, height, false);
    camera.aspect = width / height;
    camera.updateProjectionMatrix();
  }
}

function cleanup() {
  // Dispose of geometries and materials to free up memory
  for (const cube of board) {
    cube.geometry.dispose();
    cube.material.dispose();
  }
  // Remove objects from the scene
  for (const cube of board) {
    scene.remove(cube);
  }
  // Clear the board array
  board.length = 0;

  // Clean up the WebGLRenderer
  renderer.dispose();
}

function start() {
  init();
  //  createChessBoard();
  loadModel();
  animate();
}

// Add an event listener to clean up when the window is closed
window.addEventListener("beforeunload", () => {
  cleanup();
});

// Keyboard Events
window.addEventListener(
  "keydown",
  function (event) {
    switch (event.keyCode) {
      case 38:
      case 87:
        moveForward = true;
        break;
      case 37:
      case 65:
        moveLeft = true;
        break;
      case 40:
      case 83:
        moveBackward = true;
        break;
      case 39:
      case 68:
        moveRight = true;
        break;
    }
  },
  false
);

window.addEventListener(
  "keyup",
  function (event) {
    switch (event.keyCode) {
      case 38:
      case 87:
        moveForward = false;
        break;
      case 37:
      case 65:
        moveLeft = false;
        break;
      case 40:
      case 83:
        moveBackward = false;
        break;
      case 39:
      case 68:
        moveRight = false;
        break;
    }
  },
  false
);

// Mouse Events
window.addEventListener(
  "mousedown",
  function (event) {
    isMouseDown = true;
    mouseX = event.clientX;
    mouseY = event.clientY;
  },
  false
);

window.addEventListener(
  "mousemove",
  function (event) {
    if (isMouseDown) {
      const dx = event.clientX - mouseX;
      const dy = event.clientY - mouseY;
      camera.rotation.y += dx * 0.009;
      camera.rotation.x -= dy * 0.009;
      mouseX = event.clientX;
      mouseY = event.clientY;
    }
  },
  false
);

window.addEventListener(
  "mouseup",
  function (event) {
    isMouseDown = false;
  },
  false
);

start();
