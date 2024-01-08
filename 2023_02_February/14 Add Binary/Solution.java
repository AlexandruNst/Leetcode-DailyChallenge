class Solution {
    public String addBinary(String a, String b) {
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int carryOver = 0;
        StringBuilder answer = new StringBuilder();

        while(aIndex >= 0 || bIndex >= 0){
            int sum = 0;

            if(aIndex >= 0) sum += a.charAt(aIndex) - '0';
            if(bIndex >= 0) sum += b.charAt(bIndex) - '0';
            sum += carryOver;

            int digit = sum % 2;
            carryOver = sum / 2;

            answer.append(digit);
            aIndex--;
            bIndex--;
        }
        if(carryOver == 1) answer.append("1");
        
        return answer.reverse().toString();
    }
}