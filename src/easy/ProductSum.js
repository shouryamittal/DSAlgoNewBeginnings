
// Q: Find product sum of the array containing integers and other arrays.


//method : For each element check if its an integer, if yes, just sum it up, else if its aaray, recursively call the
//function again.
//Time: O(N) => N is total number of elements in array, i.e. includes the each element of each insider array too/
// Space: O(D) => D is depth of the array, bcz at a moment, we would have D numbers of function call on the stack, here D = 3 in the example.
function findProductSumRec(arr, depth) {
    let sum = 0;
    for(let i = 0 ; i < arr.length; i++) {
        if(Number.isInteger(arr[i])) {
            sum += arr[i];
        }
        else if (Array.isArray(arr[i])) {
            sum += findProductSumRec(arr[i], depth + 1);
        }
    }

    return (sum * depth);
}


function findProductSum(arr) {
    let depth = 1;
    console.log(findProductSumRec(arr, depth));
}
findProductSum([2,3, [4,5],6,[7,[8,9]]]);