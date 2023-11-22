data Tree a
  = EmptyTree
  | Leaf a
  | Node Int a (Tree a) (Tree a)
  | Node2 Int a (Tree a) (Tree a) (Tree a)

height :: Tree t -> Int
height (Leaf _) = 0
height (Node h _ _ _) = h
height (Node2 h _ _ _ _) = h

smallest :: Tree t -> t
smallest (Leaf x) = x
smallest (Node _ s _ _) = s
smallest (Node2 _ s _ _ _) = s

toList :: Tree t -> [t]
toList a = prepend a []


prepend :: Tree t -> [t] -> [t]
prepend EmptyTree xs = xs
prepend (Leaf x) xs = x : xs
prepend (Node _ _ a b) xs = prepend a (prepend b xs)
prepend (Node2 _ _ a b c) xs = prepend a (prepend b (prepend c xs))



node :: Tree t -> Tree t -> Tree t
node a = Node (height a + 1) (smallest a) a

node2 :: Tree t -> Tree t -> Tree t -> Tree t
node2 a = Node2 (height a + 1) (smallest a) a



levelUp :: [Tree t] -> [Tree t]
levelUp [a, b] = [node a b]
levelUp [a, b, c] = [node2 a b c]
levelUp [a, b, c, d] = [node a b, node c d]

mergeToSameHeight :: Tree t -> Tree t -> [Tree t]
mergeToSameHeight a b
  | height a < height b =
      case b of
        Node _ _ b1 b2 -> levelUp (mergeToSameHeight a b1 ++ [b2])
        Node2 _ _ b1 b2 b3 -> levelUp (mergeToSameHeight a b1 ++ [b2, b3])
  | height a > height b =
      case a of
        Node _ _ a1 a2 -> levelUp (a1 : mergeToSameHeight a2 b)
        Node2 _ _ a1 a2 a3 -> levelUp ([a1, a2] ++ mergeToSameHeight a3 b)
  | otherwise = [a, b]

merge :: Tree t -> Tree t -> Tree t
merge a EmptyTree = a
merge EmptyTree b = b
merge a b =
  case mergeToSameHeight a b of
    [t] -> t
    [t, u] -> node t u

split :: (t -> Bool) -> Tree t -> (Tree t, Tree t)
split _ EmptyTree = (EmptyTree, EmptyTree)
split f (Leaf x)
  | f x = (EmptyTree, Leaf x)
  | otherwise = (Leaf x, EmptyTree)
split f (Node _ _ a b)
  | f (smallest b) =
      let (a1, a2) = split f a in (a1, merge a2 b)
  | otherwise =
      let (b1, b2) = split f b in (merge a b1, b2)
split f (Node2 _ _ a b c)
  | f (smallest b) =
      let (a1, a2) = split f a in (a1, merge a2 (node b c))
  | f (smallest c) =
      let (b1, b2) = split f b in (merge a b1, merge b2 c)
  | otherwise =
      let (c1, c2) = split f c in (merge (node a b) c1, c2)



contains :: (Ord t) => Tree t -> t -> Bool
contains a x =
  case split (>= x) a of
    (_, EmptyTree) -> False
    (_, a2) -> smallest a2 == x

insert :: (Ord t) => Tree t -> t -> Tree t
insert a x =
  let (a1, a2) = split (>= x) a
   in a1 `merge` Leaf x `merge` a2

delete :: (Ord t) => Tree t -> t -> Tree t
delete a x =
  let (a1, a2) = split (>= x) a
      (_, a3) = split (> x) a2
   in merge a1 a3


fromList :: (Ord t) => [t] -> Tree t
fromList = foldl insert EmptyTree


printTree :: (Show a) => Tree a -> IO ()
printTree tree = putStr (formatTree 0 tree)
  where
    formatTree :: (Show a) => Int -> Tree a -> String
    formatTree _ EmptyTree = ""
    formatTree depth (Leaf x) = replicate (depth * 4) ' ' ++ show x ++ "\n"
    formatTree depth (Node _ val a b) =
      let spacing = replicate (depth * 4) ' '
       in spacing ++ show val ++ "\n" ++ formatTree (depth + 1) a ++ formatTree (depth + 1) b
    formatTree depth (Node2 _ val a b c) =
      let spacing = replicate (depth * 4) ' '
       in spacing ++ show val ++ "\n" ++ formatTree (depth + 1) a ++ formatTree (depth + 1) b ++ formatTree (depth + 1) c

indent :: Int -> String -> String
indent level text = replicate (level * 2) ' ' ++ text


main :: IO ()
main = do
  let tree = fromList [3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5] :: Tree Int
  putStrLn "Initial tree:"
  print (toList tree)

  let tree' = insert tree 7
  putStrLn "\nTree after inserting 7:"
  print (toList tree')

  let tree'' = delete tree' 1
  putStrLn "\nTree after deleting 1:"
  print (toList tree'')

  putStrLn "\nDoes the tree contain 5?"
  print (contains tree'' 5)

  putStrLn "\nDoes the tree contain 8?"
  print (contains tree'' 8)

  let tree = fromList [3, 10, 6, 15, 20, 18] :: Tree Int
  putStrLn "Initial tree:"
  printTree tree
