-- CA320: Computability and Complexity
-- Higher Order Functions
-- WickTheThird

import Data.List (intercalate)

data Tree myTree = EmptyTree | Node myTree (Tree myTree) (Tree myTree)

insert :: (Ord val) => val -> Tree val -> Tree val
insert x EmptyTree = Node x EmptyTree EmptyTree
insert x (Node val left right)
  | x < val = Node val (insert x left) right
  | x > val = Node val left (insert x right)
  | otherwise = Node val left right

treeToString :: (Show myTree) => Tree myTree -> String
treeToString EmptyTree = ""
treeToString (Node val left right) =
  treeToString left ++ show val ++ " " ++ treeToString right

treeHeight :: Tree myTree -> Int
treeHeight EmptyTree = 0
treeHeight (Node _ left right) = 1 + max (treeHeight left) (treeHeight right)

getValuesAtPos :: Tree myTree -> Int -> Maybe myTree
getValuesAtPos EmptyTree _ = Nothing
getValuesAtPos (Node val _ _) 1 = Just val
getValuesAtPos (Node _ left right) pos
  | pos < 0 = Nothing
  | even pos = getValuesAtPos right (pos `div` 2)
  | otherwise = getValuesAtPos left (pos `div` 2)

printTree :: (Show a) => Tree a -> IO ()
printTree tree = putStr (formatTree 0 tree)
  where
    formatTree :: (Show a) => Int -> Tree a -> String
    formatTree _ EmptyTree = ""
    formatTree depth (Node val left right) =
      let spacing = replicate (depth * 4) ' '
       in spacing ++ show val ++ "\n" ++ formatTree (depth + 1) left ++ formatTree (depth + 1) right

main :: IO ()
main = do
  let tree = Node 5 (Node 1 EmptyTree (Node 3 EmptyTree EmptyTree)) (Node 7 EmptyTree EmptyTree)
  putStrLn $ treeToString tree

  let newTree = insert 4 tree

  putStrLn $ treeToString newTree

  printTree newTree
