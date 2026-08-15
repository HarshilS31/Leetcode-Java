class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int time =0;
        int currFloor=0;
        for(int floor : requests) {
            time+=Math.abs(floor-currFloor);
            currFloor = floor;

        }
        return time; 
    }
}