package org.spring.server.leetcode.competition.week192;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author hitopei
 *
 * 5430. 设计浏览器历史记录
 * 你有一个只支持单个标签页的 浏览器 ，最开始你浏览的网页是 homepage ，你可以访问其他的网站 url ，也可以在浏览历史中后退 steps 步或前进 steps 步。
 *
 * 请你实现 BrowserHistory 类：
 *
 * BrowserHistory(string homepage) ，用 homepage 初始化浏览器类。
 * void visit(string url) 从当前页跳转访问 url 对应的页面  。执行此操作会把浏览历史前进的记录全部删除。
 * string back(int steps) 在浏览历史中后退 steps 步。如果你只能在浏览历史中后退至多 x 步且 steps > x ，那么你只后退 x 步。请返回后退 至多 steps 步以后的 url 。
 * string forward(int steps) 在浏览历史中前进 steps 步。如果你只能在浏览历史中前进至多 x 步且 steps > x ，那么你只前进 x 步。请返回前进 至多 steps步以后的 url 。
 */
public class BrowserHistory {

    private Deque<String> history = new ArrayDeque<>();
    private Deque<String> forword = new ArrayDeque<>();

    public BrowserHistory(String homepage) {
        history.add(homepage);
    }

    public void visit(String url) {
        history.add(url);
        forword.clear();
    }

    public String back(int steps) {
        for (int i=0; i< steps; i++){
            String back = history.peekLast();
            if (history.size() > 1){
                history.removeLast();
                forword.addLast(back);
            }else {
                return history.peekLast();
            }
        }
        return history.peekLast();
    }

    public String forward(int steps) {
        if (forword.isEmpty()){
            return history.peekLast();
        }
        for (int i=0; i< steps; i++) {
            String url = forword.peekLast();
            if (forword.size() > 1){
                forword.removeLast();
                history.addLast(url);
            }else {
                return forword.peekLast();
            }
        }
        return history.peekLast();
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("zav.com");
        browserHistory.visit("kni.com");
        System.out.println(browserHistory.back(7));
        System.out.println(browserHistory.back(7));
        System.out.println(browserHistory.forward(5));
        System.out.println(browserHistory.forward(1));
        browserHistory.visit("pwrrbnw.com");
        browserHistory.visit("mosohif.com");
        System.out.println(browserHistory.back(9));
    }
}
