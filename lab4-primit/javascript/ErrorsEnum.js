const prompt=require("prompt-sync")({sigint:true}); 

const Error_enumobj = {
	FP_ROUNDING: "FP_ROUNDING",
	FP_OVERFLOW: "FP_OVERFLOW",
	FP_UNDERFLOW: "FP_UNDERFLOW",
	INT_OVERFLOW: "INT_OVERFLOW"
}

const Result_enumobj = {
    A_BIT_DIFFERENT: "A_BIT_DIFFERENT", 
    INFINITY: "INFINITY", 
    ZERO: "ZERO", 
    VERY_DIFFERENT: "VERY_DIFFERENT"
}

function error2Result(err){
    switch (err) {
	case Error_enumobj.FP_ROUNDING:
	 return Result_enumobj.A_BIT_DIFFERENT;
	break;
	case Error_enumobj.FP_OVERFLOW:
	    return Result_enumobj.INFINITY;
	break;
	case Error_enumobj.FP_UNDERFLOW:
	    return Result_enumobj.ZERO;
	break;
	case Error_enumobj.INT_OVERFLOW:
	    return Result_enumobj.VERY_DIFFERENT;
	break;
	default:
		return 'Invalid Error value';
}

}

function result2Error(result) {
	switch (result) {
		case Result_enumobj.A_BIT_DIFFERENT:
			return Error_enumobj.FP_ROUNDING;
		case Result_enumobj.INFINITY:
			return Error_enumobj.FP_OVERFLOW;
		case Result_enumobj.ZERO:
			return Error_enumobj.FP_UNDERFLOW;
		case Result_enumobj.VERY_DIFFERENT:
			return Error_enumobj.INT_OVERFLOW;
		default:
			return 'Invalid Result value';		
	}
}

console.log('Result list: ', Object.values(Result_enumobj));
var validArg = false;
while(!validArg){
    var input = prompt("Input: ");
    let error = result2Error(input);
    if (Object.values(Error_enumobj).includes(error)){
        validArg = true;
		console.log(input + " results in " + error);
    }
    else{
        console.log(error);
    }
}
