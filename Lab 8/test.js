var assert = require('assert');
var javascriptFunctions = require('../javascriptFunctions');
var octalConverter = require('../OctalConverter')

describe('givenADecimalNumberThenOctalIsReturned()', function() {
    it('decimal(1) = 1', function() {
        
        // Given
        var decimalNumber = 1;
        var expectedResult = 1;

        // When
        var actualResult = octalConverter.decimalToOctal(decimalNumber);

        // Then
        assert.equal(expectedResult, actualResult);
    });

    it('decimal(2) = 2', function() {
        
        // Given
        var decimalNumber = 2;
        var expectedResult = 2;

        // When
        var actualResult = octalConverter.decimalToOctal(decimalNumber);

        // Then
        assert.equal(expectedResult, actualResult);
    });

    it('decimal(8) = 10', function() {
        
        // Given
        var decimalNumber = 8;
        var expectedResult = 10;

        // When
        var actualResult = octalConverter.decimalToOctal(decimalNumber);

        // Then
        assert.equal(expectedResult, actualResult);
    });

    it('decimal(95) = 137', function() {
        
        // Given
        var decimalNumber = 95;
        var expectedResult = 137;

        // When
        var actualResult = octalConverter.decimalToOctal(decimalNumber);

        // Then
        assert.equal(expectedResult, actualResult);
    });

    it('decimal(2048) = 4000', function() {
        
        // Given
        var decimalNumber = 2048;
        var expectedResult = 4000;

        // When
        var actualResult = octalConverter.decimalToOctal(decimalNumber);

        // Then
        assert.equal(expectedResult, actualResult);
    });
});

describe('givenTwoIntegersWhenSumThenSuccess()', function() {
    it('sum(1, 2) = 3', function() {

        // Given 
        var a = 1;
        var b = 2;
        var expectedResult = 3;

        // When 
        var actualResult = javascriptFunctions.sum(a, b);

        // Then
        assert.equal(expectedResult, actualResult);
    });
})
