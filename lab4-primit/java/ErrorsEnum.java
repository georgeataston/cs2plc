import java.util.Scanner;
import java.util.EnumSet;

public class ErrorsEnum
{
    enum Error { FP_ROUNDING, FP_OVERFLOW, FP_UNDERFLOW, INT_OVERFLOW }

    enum Result { A_BIT_DIFFERENT, INFINITY, ZERO, VERY_DIFFERENT }
    
    private static <E extends Enum<E>> E getEnumElement(String elementTypeName, Class<E> elementType)
    {
        boolean haveResult = false;
        E result = null;
        Scanner stdin = new Scanner(System.in);
        
        while ( ! haveResult )
        {
            System.out.print("Input " + elementTypeName + ": ");
            try
            {
                result = Enum.valueOf(elementType, stdin.next().toUpperCase());
                haveResult = true;
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Not a valid " + elementTypeName + ".");
                stdin.nextLine(); // skip the invalid input
            }
        }
        
        stdin.close();
        return result;
    }
  
    private static Result error2Result(Error e)
    {
        Result result = null;
        
        switch (e) {
        case FP_ROUNDING:
            result = Result.A_BIT_DIFFERENT;
            break;
        case FP_OVERFLOW:
            result = Result.INFINITY;
            break;
        case FP_UNDERFLOW:
            result = Result.ZERO;
            break;
        case INT_OVERFLOW:
            result = Result.VERY_DIFFERENT;
            break;
        }
        
        return result;
    }

    private static Error result2Error(Result result) {
        switch (result) {
            case A_BIT_DIFFERENT:
                return Error.FP_ROUNDING;
            case INFINITY:
                return Error.FP_OVERFLOW;
            case ZERO:
                return Error.FP_UNDERFLOW;
            case VERY_DIFFERENT:
                return Error.INT_OVERFLOW;
        }

        return null;
    }

    public static void main(String[] args)
    {
        System.out.print("Known results = ");
        for (Result r : EnumSet.allOf(Result.class)) 
        {
            System.out.print(r + " ");
        }
        System.out.println();
        
        Result e = getEnumElement("result", Result.class);
        System.out.println(e + " results in: " + result2Error(e));
    }
}
