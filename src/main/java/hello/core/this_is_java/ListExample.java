package hello.core.this_is_java;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
    BoardDao dao = new BoardDao();
    List<Board> list = dao.getBoardList();

    for(Board board : list){
        System.out.println(board.getTitle()+"-"+board.getContent());
        }

    List<String> deleteList = new ArrayList<>();
    deleteList.add("Hong");
    deleteList.add("kim");
    deleteList.add("gang");
    deleteList.add("kim");
    deleteList.add(null);
        System.out.println(deleteList.get(0));
        System.out.println(deleteList.get(4));
//        System.out.println(deleteList.get(5)); -> out of index
        deleteList.remove("kim");
        System.out.println(deleteList.get(1)); // -> ArrayList에서 값을 삭제하면 빈 깡통으로 남는다.
        System.out.println(deleteList.get(3)); // 객체로 remove를 때리면 같은 객체는 모두 지워진다.
        // 왜 와이? 같은 객체를 저장하면 같은 주소값을 참조하기 때문에
    }
}
