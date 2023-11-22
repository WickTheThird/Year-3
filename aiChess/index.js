import * as THREE from "three";
import { OrbitControls } from "three/examples/jsm/controls/OrbitControls";

let scene, camera, renderer, controls;
const tileSize = 1;
const board = [];

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

  controls = new OrbitControls(camera, renderer.domElement);
  camera.position.z = 5;
}

function createChessBoard() {
  for (let x = 0; x < 8; x++) {
    for (let y = 0; y < 8; y++) {
      const geometry = new THREE.BoxGeometry(tileSize, tileSize, tileSize);
      const material = new THREE.MeshBasicMaterial({
        color: (x + y) % 2 === 0 ? 0xffffff : 0x808080,
      });
      const cube = new THREE.Mesh(geometry, material);
      cube.position.set((y - 3.5) * tileSize, (x - 3.5) * tileSize, 0);
      scene.add(cube);
      board.push(cube);
    }
  }
}

function animate() {
  requestAnimationFrame(animate);
  resizeRendererToDisplaySize();
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

  // Dispose of controls
  controls.dispose();

  // Clean up the WebGLRenderer
  renderer.dispose();
}

function start() {
  init();
  createChessBoard();
  animate();
}

// Add an event listener to clean up when the window is closed
window.addEventListener("beforeunload", () => {
  cleanup();
});

start();
