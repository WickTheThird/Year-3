
isPalindrome :: Eq a => [a] -> Bool
isPalindrome list = list == reverse list

shortest :: Eq a => [[a]] -> [a]
shortest [] = []
shortest [x] = x
shortest (x:xs)
    | length x < length short = x
    | otherwise = short
    where short = shortest xs

addPol :: [Int] -> [Int] -> [Int]
addPol [] [] = []
addPol [] (y:ys) = y : addPol [] ys


main :: IO ()
main = do

    let testRev = isPalindrome [1,2,3,2,1]
    let testRev2 = isPalindrome [1, 2, 3, 4, 5]
    putStrLn ("Ex1 [1, 2, 3, 2, 1] : " ++ show testRev)
    putStrLn ("Ex1 [1, 2, 3, 4, 5] : " ++ show testRev)

    putStrLn "lab3 redo"
