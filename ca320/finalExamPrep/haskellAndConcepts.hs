

{-
This will be a file containing all the theoreticall knowledge about haskell.
We shall have a separate file that will go through some of the labs we did throughout the semester to revise these topics.

We have the following to cover:
    - Imertative vs Declarative [X]
    - Advantages and Disadvantages of Declarative Languates [X]
    - Lists [X] 
        i. ranges [X]
        ii. comprehensions [X]
    - Tuples [X]
    - Type Classes [X]
    - Pattern Matching and Recursion [ ]
    - Guards [ ]
    - Higher Order Functions [ ]
    - Lambda Functions [ ]
    - I.O and file IO [ ]
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

main :: IO ()
main = do
    putStrLn "Hello World!"
