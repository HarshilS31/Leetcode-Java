class Solution {
    private static final int[] DAYS_BEFORE_MONTH = {
            0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334
    };
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aArrive = toDays(arriveAlice);
        int aLeave = toDays(leaveAlice);
        int bArrive = toDays(arriveBob);
        int bLeave = toDays(leaveBob);
        int maxArrival = Math.max(aArrive,bArrive);
        int leaveMin = Math.min(aLeave,bLeave);
        return Math.max(0,leaveMin-maxArrival+1);
    }
    public int toDays(String date) {
        int month = Integer.parseInt(date.substring(0,2));
        int days = Integer.parseInt(date.substring(3));
        return DAYS_BEFORE_MONTH[month-1]+days;

    }
}