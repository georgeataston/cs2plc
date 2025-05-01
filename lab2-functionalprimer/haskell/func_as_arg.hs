--create inpFunc
inpFunc = [a..b] 
a = 1
b = 10

--Define applicatorFunc
--applicatorFunc inpFunc s = if s=='s' then sum inpFunc else (sum inpFunc)/5  
applicatorFunc inpFunc s | s == 's' = sum inpFunc
                         | s == 'a' = (sum inpFunc)/5

main = do
    let result = applicatorFunc inpFunc 'a' --Call applicatorFunc with inpFunc and 'a' as args
    putStrLn("sum = " ++ show(result))