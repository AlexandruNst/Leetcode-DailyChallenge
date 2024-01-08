import java.util.ArrayList;
import java.util.List;

class BrowserHistory {
    List<String> history;
    int currPage;
    int lastPage;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        currPage = 0;
        lastPage = 0;
    }

    public void visit(String url) {
        currPage++;
        if (currPage < history.size()) {
            history.set(currPage, url);
        } else {
            history.add(url);
        }
        lastPage = currPage;
    }

    public String back(int steps) {
        currPage = Math.max(0, currPage - steps);
        return history.get(currPage);
    }

    public String forward(int steps) {
        currPage = Math.min(lastPage, currPage + steps);
        return history.get(currPage);
    }
}