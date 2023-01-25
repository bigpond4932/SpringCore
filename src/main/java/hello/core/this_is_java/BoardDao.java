package hello.core.this_is_java;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
    public List<Board> getBoardList(){
        List<Board> list = new ArrayList<>(); // ArrayList , LinkedList
//        list.add(); -> plus
//        list.set(); -> overriding = replace
        Board board1 = new Board("title1","content1");
        Board board2 = new Board("title2","content2");
        Board board3 = new Board("title3","content3");
        list.add(board1);
        list.add(board2);
        list.add(board3);
        return list;
    }
}
