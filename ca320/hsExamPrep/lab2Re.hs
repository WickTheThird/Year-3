area :: Float -> Float -> Float -> Float
area a b c = sqrt (s*(s-a)*(s-b)*(s-c))
    where s = (a+b+c)/2

sumTest :: Int -> Int -> Int -> Bool
sumTest a b c = a + b == c

areaCheck :: Float -> Float -> Float -> Float
areaCheck a b c = 
    if (a + b > c) && (a + c > b) && (b + c > a) 
        then area a b c 
    else error "Not a triangle!"

main :: IO()
main = do
    -- EX 1
    -- putStrLn "Enter the length of the first side of the triangle: "
    -- a <- getLine
    -- putStrLn "Enter the length of the second side of the triangle: "
    -- b <- getLine
    -- putStrLn "Enter the length of the third side of the triangle: "
    -- c <- getLine
    -- let a' = read a :: Float
    -- let b' = read b :: Float
    -- let c' = read c :: Float
    -- let area' = area a' b' c'

    -- putStrLn ("The area of the triangle is: " ++ show area')

    -- EX 2
    -- putStrLn "Enter first number"
    -- a <- getLine
    -- putStrLn "Enter second number"
    -- b <- getLine
    -- putStrLn "Enter third number"
    -- c <- getLine

    -- let a' = read a :: Int
    -- let b' = read b :: Int
    -- let c' = read c :: Int

    -- let sumTest' = sumTest a' b' c'

    -- putStrLn ("The sum of the first two numbers is equal to the third number: " ++ show sumTest')

    -- EX 3
    -- putStrLn "Enter the length of the first side of the triangle: "
    -- a <- getLine
    -- putStrLn "Enter the length of the second side of the triangle: "
    -- b <- getLine
    -- putStrLn "Enter the length of the third side of the triangle: "
    -- c <- getLine
    -- let a' = read a :: Float
    -- let b' = read b :: Float
    -- let c' = read c :: Float
    -- let area' = areaCheck a' b' c'

    -- putStrLn ("The area of the triangle is: " ++ show area')

    putStrLn "lab2 redo"
