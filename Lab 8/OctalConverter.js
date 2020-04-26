function decimalToOctal(decimalNumber) {
    var octal = []
    var counter = 0
    var octalString = ""

    do {
        octal[counter] = decimalNumber % 8;
        decimalNumber = Math.floor(decimalNumber /= 8);
        counter++;
    } while(decimalNumber != 0);

    octal = octal.reverse();

    for(var i=0; i<counter; i++){
        octalString = octalString + octal[i];
    }

    return parseInt(octalString);
}

exports.decimalToOctal = decimalToOctal
