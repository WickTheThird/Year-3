--CA320: Computability and Complexity
--
-- WickTheThird

diff :: Int -> Int -> Int
diff x y = abs (x-y)


-- 1 Area of a rectangle

area :: Float -> Float -> Float -> Float
area a b c = sqrt (s*(s-a)*(s-b)*(s-c))
  where s = (a+b+c)/2


-- 2 Sum Test

sumTest :: Int -> Int -> Int -> Bool
sumTest a b c = (a+b) == c || (a+b) == b || (a+b) == a

-- 3 Area Revised

triangleCheck :: Float -> Float -> Float -> Float
triangleCheck a b c =
    if a + b > c && a + c > b && c + b > a
    then area a b c
  else error "Batman is not a triangle!"

