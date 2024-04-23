class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[] arrivalTime = new double[target];
        
        // Compute the times each car will take to arrive at the target position relative
        // to their current positions and speeds.
        for (int i = 0; i < position.length; i++) {
            arrivalTime[position[i]] = (double)(target - position[i]) / speed[i];
        }
        
        int fleetCount = 0;
        double prevTime = 0.0;
        
        // If preceding cars have a faster arrival time than cars succeeding them, a fleet will
        // form. Count the number of such occurrences.
        for (int i = target - 1; i >= 0; i--) {
            double curTime = arrivalTime[i];
            if (curTime > prevTime) {
                prevTime = curTime;
                fleetCount++;
            }
        }
        
        return fleetCount;
    }
}