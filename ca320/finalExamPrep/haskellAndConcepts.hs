

{-
This will be a file containing all the theoreticall knowledge about haskell.
We shall have a separate file that will go through some of the labs we did throughout the semester to revise these topics.

We have the following to cover:
    - Imertative vs Declarative [X]
    - Advantages and Disadvantages of Declarative Languates [X]
    - Lists [ ] 
        i. ranges [ ]
        ii. comprehensions [ ]
    - Tuples [ ]
    - Type Classes [ ]
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

main :: IO ()
main = do
    putStrLn "Hello World!"
