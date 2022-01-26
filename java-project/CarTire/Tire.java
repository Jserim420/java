public class Tire {
    int maxRotation;
    int accumulatedRotation;
    String location;

    Tire(String location, int maxRotation){
        this.location=location;
        this.maxRotation=maxRotation;
    }

    boolean roll(){
        ++accumulatedRotation;
        if(accumulatedRotation<maxRotation){
            System.out.println(location + " 타이어의 수명 : " + (maxRotation-accumulatedRotation) + "회");
            return true;
        } else {
            System.out.println(location + "타이어가 펑크 났습니다.");
            return false;
        }
    }
}
