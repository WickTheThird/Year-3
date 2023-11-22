--CA320: Computability and Complexity
--
-- WickTheThird


-- 1 Palindrome

isPalindrome :: Eq a => [a] -> Bool
isPalindrome list = list == reverse list


-- 2 Shortest List

shortestList :: [[a]] -> [a]
shortestList [] = []
shortestList [x] = x
shortestList (x:xs) 
    | length x < length shortest = x
    | otherwise = shortest
    where shortest = shortestList xs


-- 3 Adding Two Polynomials

equalizeLists :: [Int] -> [Int] -> ([Int], [Int])
equalizeLists list1 list2 = 
  let len1 = length list1
      len2 = length list2
      diff = abs (len1 - len2)
      list1' = if len1 < len2 then list1 ++ replicate diff 0 else list1
      list2' = if len2 < len1 then list2 ++ replicate diff 0 else list2
  in (list1', list2')

sumPoly :: [Int] -> [Int] -> [Int]
sumPoly xs ys =
  let (xs', ys') = equalizeLists xs ys
  in sumPoly' xs' ys'
  where
    sumPoly' [] [] = []
    sumPoly' (x:xs) (y:ys) = (x + y) : sumPoly' xs ys


-- 4 Solving for x

evalPoly :: Int -> [Int] -> Int
evalPoly x [] = 0
evalPoly x (y:ys) = y + x * evalPoly x ys
