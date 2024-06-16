class Solution {
    public int hammingWeight(int n) {

        // The below algorithm essentially checks the value of each bit.
        // This value check is performed at the MSB (assume a little-endian architecture).
        // The MSB is updated on each iteration using a right shift operation, until all bits are processed.

        int setBitCount = 0;
        
        while (n != 0) {
            if ((n & 1) == 1) {
                setBitCount++;
            }

            n >>= 1;
        }

        return setBitCount;
    }
}