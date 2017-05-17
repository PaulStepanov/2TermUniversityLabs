package domain;

public class ArrayServiceTest {
    private ArrayService arrayService = new ArrayService();



    @org.junit.Test
    public void fillRandomNumbers() throws Exception {
        arrayService.fillRandomNumbers(100);
        //arrayService.getActualNumList().forEach(System.out::println);
    }

    @org.junit.Test
    public void addElement() throws Exception {

    }

    @org.junit.Test
    public void getActualNumList() throws Exception {

    }

    @org.junit.Test
    public void processList() throws Exception {

    }

    @org.junit.Test
    public void changeList() throws Exception {
        arrayService.fillRandomNumbers(2);
        arrayService.getActualNumList().forEach(System.out::println);
        arrayService.changeList();
        arrayService.getActualNumList().forEach(System.out::println);
    }

}