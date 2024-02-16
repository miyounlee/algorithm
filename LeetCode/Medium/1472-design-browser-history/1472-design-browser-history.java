class BrowserHistory {
    LinkedList<String> history = new LinkedList<>();
    int index = 0;

    public BrowserHistory(String homepage) {
        history.add(homepage);
    }

    void visit(String url) {
        index++;
        history.add(index, url);
        while(index < history.size() - 1) {
            history.removeLast();
        }
    }

    String back(int steps) {
        if (steps >= index) {
            index = 0;
            return history.getFirst();
        }
        index -= steps;
        return history.get(index);
    }

    String forward(int steps) {
        if (steps >= (history.size() - 1) - index) {
            index = history.size() - 1;
            return history.getLast();
        }
        index += steps;
        return history.get(index);
    }
}