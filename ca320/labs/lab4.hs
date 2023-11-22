--CA320: Computability and Complexity
--
-- WickTheThird

-- 1 Develop my own list functions

-- 1.1 myAppend
myAppend :: [a] -> [a] -> [a]
myAppend [] ys = ys
myAppend (x:xs) ys = x : myAppend xs ys

-- myHead
myHead :: [a] -> a
myHead (x:xs) = x

-- myLast
myLast :: [a] -> a
myLast [x] = x
myLast (x:xs) = myLast xs

-- myTail
myTail :: [a] -> [a]
myTail [] = []
myTail (x:xs) = xs

-- myInit
myInit :: Eq a => [a] -> [a]
myInit [x] = []
myInit (x:xs) = 
    if x /= last xs then x : myInit xs else []

-- myLength
myLength :: [a] -> Int
myLength [] = 0
myLength (x:xs) = 1 + myLength xs

-- myReverse
myReverse :: Eq a => [a] -> [a]
myReverse [] = []
myReverse (x:xs) = myReverse xs ++ [x]

-- myConcat
myConcat :: [[a]] -> [a]
myConcat [] = []
myConcat (x:xs) = x ++ myConcat xs

-- mySum
mySum :: Num a => [a] -> a
mySum [] = 0
mySum (x:xs) = x + mySum xs

-- myProduct
myProduct :: Num a => [a] -> a
myProduct [] = 1
myProduct (x:xs) = x * myProduct xs

-- myMaximum
myMaximum :: [Int] -> Int
myMaximum [x] = x
myMaximum (x:xs) = 
    if x > myMaximum xs then x else myMaximum xs

-- myMinimum
myMinimum :: [Int] -> Int
myMinimum [x] = x
myMinimum (x:xs) = 
    if x < myMinimum xs then x else myMinimum xs

-- myElem
myElem :: Eq a => a -> [a] -> Bool
myElem x [] = False
myElem x (y:ys) = 
    if x == y then True else myElem x ys

-- myDelete
myDelete :: Eq a => a -> [a] -> [a]
myDelete x [] = []
myDelete x (y:ys) = 
    if x == y then myDelete x ys else y : myDelete x ys


-- 2 Set functions for lists

-- myUnion
myUnion :: Eq a => [a] -> [a] -> [a]
myUnion [] [] = []
myUnion [] ys = ys
myUnion xs [] = xs
myUnion (x:xs) ys = 
    if myElem x ys then myUnion xs ys else x : myUnion xs ys


-- myIntersect
myIntersect :: Eq a => [a] -> [a] -> [a]
myIntersect [] [] = []
myIntersect [] ys = []
myIntersect xs [] = []
myIntersect (x:xs) ys = 
    if myElem x ys then x : myIntersect xs ys else myIntersect xs ys
