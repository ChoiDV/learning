// JavaScript source code
function sumAll() {
    var result = 0;   
    if (arguments.length == 0) {
        result = -999;
    } else if (arguments.length >= 1) {
        for (idx = 0; idx < arguments.length; idx++) {
            result += arguments[idx];
        }
    }
    return result;     
}