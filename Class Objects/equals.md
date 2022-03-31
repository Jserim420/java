# equals()
- ```Objects.equals(Object a, Object b)``` : 두 객체의 동등을 비교
- a와 b가 모두 ```null```일 경우 ```true```를 리턴
- a와 b중 둘 중 하나가 ```null```일 경우 ```false```를 리턴
- a와 b가 모두 ```null```이 아닌 경우 ```a.equals(b)```의 결과를 리턴

# deepEquals()
- ```Objects.deepEquals(Object a, Object b)``` : 두 객체의 동등을 비교
- a와 b가 서로 다른 배열일 경우 항목 값이 모두 같다면 ```true```
