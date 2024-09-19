class Solution {
    private static int getSeconds(String ms) {
        String[] time = ms.split(":");
        
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
    
    private static int doPrev(int posSec) {
        return posSec > 10 ? posSec - 10 : 0;
    }
    
    private static int doNext(int posSec, int len) {
        return posSec + 10 < len ? posSec + 10 : len;
    }
    
    private static int skipOp(int posSec, int opStart, int opEnd) {
        return (opStart <= posSec && posSec < opEnd) ? opEnd : posSec;
    }
    
    private static String convertMs(int posSec) {
        int mm = posSec / 60;
        int ss = posSec % 60;
        
        return String.format("%02d:%02d", mm, ss);
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int posSec = getSeconds(pos);
        int len = getSeconds(video_len);
        int opStart = getSeconds(op_start);
        int opEnd = getSeconds(op_end);
        
        posSec = skipOp(posSec, opStart, opEnd);
        
        for (String command : commands) {
            if ("prev".equals(command)) {
                posSec = doPrev(posSec);
            } else if ("next".equals(command)) {
                posSec = doNext(posSec, len);
            }
            
            posSec = skipOp(posSec, opStart, opEnd);
        }
        
        return convertMs(posSec);
    }
}