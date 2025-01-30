--create inpFunc
inpFunc a b = [a..b] 

--Define applicatorFunc
applicatorFunc inpFunc s
    | s == 's' = sum inpFunc
    | otherwise = (sum inpFunc)/5

main = do
    let result = applicatorFunc (inpFunc 1 5) 'a' --Call applicatorFunc with inpFunc and 'a' as args
    putStrLn("sum = " ++ show(result))