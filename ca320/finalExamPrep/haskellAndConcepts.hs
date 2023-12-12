
{-
This will be a file containing all the basic theoretical knowledge about haskell (at least that i deem important).
We shall have a separate file that will go through some of the labs we did throughout the semester to revise these topics.

We have the following to cover:
    - Imertative vs Declarative [X]
    - Advantages and Disadvantages of Declarative Languates [X]
    - Lists [X] 
        i. ranges [X]
        ii. comprehensions [X]
    - Tuples [X]
    - Type Classes [X]
    - Pattern Matching and Recursion [X]
    - Guards [X]
    - Higher Order Functions [X]
    - Lambda Functions [X]
-}


imperativeDefinition :: IO ()
imperativeDefinition = do
    putStrLn "In imperative languages, you describe how to do something."
    putStrLn "Imperative languages are all about state changes how how do these changes be persistent and have a side-effect."

declarativeDefinition :: IO ()
declarativeDefinition = do
    putStrLn "In declarative languages, you describe what do to as opposed on how to do it."
    putStrLn "You describe the propreties of the solution and then the programming language searches for the solution (logical approach)."
    putStrLn "Another approach is to describe the solution as the evaulation of mathematical functions that do not rely on states and side-effects."


advantagesOfDeclarative :: IO ()
advantagesOfDeclarative = do
    putStr "1. While imperative languages relly on modeling the solution around a particular style (since the only way it makes sense is by looking at the computer hardware),"
    putStrLn "Functional programming is more abstract and you focus on modeling the problem."

    putStrLn "2. Functional programming is easier to reason/understand"

    putStr "3. Functional programming promotes good programming practices."
    putStrLn "Even if you never used a functional language before, by using it your imperative programming will improve as a whole."
    

disadvantagesOfDeclarative :: IO ()
disadvantagesOfDeclarative = do
    putStrLn "1. They are difficult when you require input and output (since these operations require side-effects)"

    putStr "2. When the user needs to interact with a continuouslly running programm."
    putStrLn "This is due to the fact that functinal languages are at a level of abstraction above the hardware, and this its hard to reason the time and complexity of the functional programs."

listsInHaskell :: IO()
listsInHaskell = do
    putStrLn "Lists are homogeneneous data structure where each element of the list has the same type"
    putStrLn "We can concatenate lists using the ++ operator"
    putStrLn "\n"
    putStrLn "We can also use the : operator to add an element to the front of the list"
    putStrLn "\n"
    putStrLn "We can also use the !! operator to get the element at a particular index"
    putStrLn "\n"
    putStrLn "We can use a number of list functions to take full advantage:"
    putStrLn "\n"
    putStrLn "head: returns the first element of the list"
    putStrLn "tail: returns the list without the first element"
    putStrLn "last: returns the last element of the list"
    putStrLn "init: returns the list without the last element"
    putStrLn "length: returns the length of the list"
    putStrLn "null: returns true if the list is empty"
    putStrLn "reverse: returns the list in reverse order"
    putStrLn "take: returns the first n elements of the list"
    putStrLn "drop: returns the list without the first n elements"
    putStrLn "maximum: returns the maximum element of the list"
    putStrLn "minimum: returns the minimum element of the list"
    putStrLn "sum: returns the sum of the elements of the list"
    putStrLn "product: returns the product of the elements of the list"
    putStrLn "elem: returns true if the element is in the list"

listRanges :: IO ()
listRanges = do
    putStrLn "Rather than having to write down all the elements of a list, we can user ranges if there is a regular interval between the elements."
    putStrLn "We can use the following syntax: [start..end]"
    putStrLn "\n"
    putStrLn "We can also make it such that it writes all of the even elements, or perhaps we want a range of characters...we can do that"
    putStrLn "We can use the following syntax: [start, step..end]"
    putStrLn "\n"
    putStrLn "We can also use the following syntax: [start..] or [start, step..] to create an infinite list"

listComprehensions :: IO ()
listComprehensions = do
    putStrLn "When we define sets we yse a technique called set comprehension e.g. {3x | x ∈ N, x <= 10}"
    putStrLn "Note: the expressions after the pipe are the predicates that the variables of the output must satisfy."
    putStrLn "\n"
    putStrLn "We can do somehting very similar for lists and this is called list comprehension"
    putStrLn "[2*X |  x <- [1..10]]"
    putStrLn "[x*y | x <- [5, 10, 15], y <- [4..6], x*y < 50]"

tuplesInHaskell :: IO ()
tuplesInHaskell = do
    putStr "A tuple has its own type and depends on its own size, the types of its components and their order."
    putStrLn "A pair is the smallest tuple. On a pair we can perform 2 functions: fst ('first') and snd ('second')."
    putStrLn "For example we can extract the first value of a pair by using: fst ('hello world', 1) -- the same goes with snd."
    putStrLn "\n"
    putStrLn "Extracting data from larger tuples, requires pattern matching and thus List Comprehensions. Yes they technically work the same as with lists (more or less)."

typeClasses :: IO ()
typeClasses = do
    putStrLn "Type Classes gives Haskell support for strong static typing and inference."
    putStrLn "They enable Haskell to enforce certain constraints on the types of values, ensuring that operations are type-sage and preventing runtime errors."
    putStrLn "\n"
    putStrLn "An example of such a constraint is  (Eq a). It means that the '==' function can only operate on types that are members of the Eq class."
    putStrLn "The Eq class includes all types except IO functions."
    putStrLn "\n"
    putStrLn "Other Type Classes are: "
    putStrLn "\n"
    putStrLn "Ord: includes all types that can be ordered (e.g. Int, Char, String, Bool, etc.). Functions in this class include '>=', '<=', and '>', '<', compare, max and min."
    putStrLn "\n"
    putStrLn "Show: includes all types that can be converted to a string (e.g. Int, Char, String, Bool, etc.). Functions in this class include 'show'."
    putStrLn "\n"
    putStrLn "Read: includes all types that can be converted from a string (e.g. Int, Char, String, Bool, etc.). Functions in this class include 'read'."
    putStrLn "\n"
    putStrLn "Num: includes all types that can be converted aka act as numbers"
    putStrLn "\n"
    putStrLn "Integral: includes all types that can be converted aka act as integers aka whole numbers"
    putStrLn "\n"
    putStrLn "\n"
    putStrLn "We can also use the :t command in haskell to determine the type of a function or item."
    putStrLn ":t head returns head::[a]->a"
    putStrLn ":t (==) returns (==)::(Eq a) => a -> a -> Bool"


patternMatchingAndRecursion :: IO()
patternMatchingAndRecursion = do
    putStrLn "Pattern matching and recursion is very common programming construct in functional programming."
    putStrLn "Recursion is where a function continuously calls itself when performing an evaulation. If not handled correctly, it can lead into an infinite loop."
    putStrLn "To prevent an infinite liip, a recursive function must have a basecase, and the parameters of each invocation of the recursive function should move closer to the base case."
    putStrLn "\n"
    putStrLn "Example of recursive function:"
    putStrLn "factorial :: Int -> Int"
    putStrLn "factorial 0 = 1"
    putStrLn "factorial n = n * factorial (n-1)"
    putStrLn "\n"
    putStrLn "Example of pattern matching:"
    putStrLn "listLength :: (Integral b) => [a] -> b"
    putStrLn "listLength [] = 0"
    putStrLn "listLength (_:xs) = 1 + listLength xs"
    putStrLn "\n"
    putStrLn "--Some notes on the above example--"
    putStrLn "\n"
    putStrLn "The base case is the empty list"
    putStrLn "If tge list we are measuring is not empty, we try the next pattern _:xs: "
    putStrLn "--> the list is matched against _:xs, which is a list with something at its head followed by a tail."
    putStrLn "--> the something ( _ ) doesn't matter to us, but the tail does."
    putStrLn "It is very important to make sure that the pattern you specify matches against all possible patterns."
    putStrLn "\n"
    putStrLn "\n"
    putStrLn "To refer to the original complete item and not just the elements of the pattern, we can use 'as patterns'."
    putStrLn "An as pattern consists of the name of the complete item followed by an @ and then the patern."
    putStrLn "For example, we can rewrite the above example as:"
    putStrLn "listLength :: (Integral b) => [a] -> b"
    putStrLn "listLength [] = 0"
    putStrLn "listLength all@(x:xs) = 1 + listLength xs"
    putStrLn "\n"


guards :: IO ()
guards = do
    putStrLn "Guards are a way of testing whether some property of a value (or several values) are true or false."
    putStrLn "Guards follow a function name and parameters. They are boolean expressions that follow a pipe (|)."
    putStrLn "When a guard evaluates to true, the function body is evaluated. If it evaluates to false, the next guard is evaluated."
    putStrLn "'otherwise' is a boolean expression that always evaluates to true and is used as the last guard."


higherOrderFunctions :: IO ()
higherOrderFunctions = do
    putStrLn "Higher order functions in Haskell are functions that can take other functions as arguments or return functions as their results."
    putStrLn "This concept is a fundamental part of functional programming, as it allowed for powerful abstractions and code reuse."
    putStrLn "\n"
    putStrLn "Haskell functions (by default) take only one parameter due to a concpet called currying."
    putStrLn "This means that functions take one argument at a time and retyrn a function that takes the next argument until all arguments are provided."
    putStrLn "This is why function type signatures in Haskell have the structure a->a->b->c and not a, a, b->c"
    putStrLn "\n"
    putStrLn "Curried functions are useful because when you supply a curried function with a fewer parameters than required, you get back a partially applied function."
    putStrLn "This is like a new function that can be used as a parameter in another function."
    putStrLn "\n"
    putStrLn "Example of a curried function:"
    putStrLn "Consider the max funtion in Haskell. Its type signature is max :: (Ord a) => a -> a -> a."
    putStrLn "When you call max 4 5, it creates a new function that takes one parameter and evaluates to 4 if the new parameter is less tham 4 or the new parameter if it is greater than 4"
    putStrLn "\n"
    putStrLn "Example of a higher order functions can be: map, filter and takeWhile."
    putStrLn "The map function applies a given function to every element of a list."
    putStrLn "The filter function takes a preducate and a list and returns a list of the elements of the original list that satisfies the predicate."
    putStrLn "The takeWhile removes elements from the start of a list while a predicate is true."
    putStrLn "\n"
    putStrLn "map (>3) [1, 8, 2, 4] evaluates to [False, True, False, True] because it applies the function '>3' to every eleent in the list."
    putStrLn "filter (>3) [1, 8, 2, 4] evaluates  to [8, 4], because it also applies the function '>3' to every element in the list."
    putStrLn "etc."

lambdaFunctions :: IO ()
lambdaFunctions = do
    putStrLn "These are anonymous functions that are mainly used as a parameter to a higher order funtion."
    putStrLn "They allow you to define functions without giving them a name. This is usefull for when you want to use a function once and never use it again afterwards."
    putStrLn "As all functions in haskell they are curried by default."
    putStrLn "\n"
    putStrLn "Example of a lambda function:"
    putStrLn "map (\\x -> x + 3) [1, 2, 3, 4] evaluates to [4, 5, 6, 7]"


main :: IO ()
main = do
    putStrLn "Hello World!"
