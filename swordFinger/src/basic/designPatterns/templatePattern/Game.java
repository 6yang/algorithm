package basic.designPatterns.templatePattern;

/**
 * @author liuyang29 <liuyang29@kuaishou.com>
 * Created on 2021-03-01
 */
public abstract class Game {
    abstract void initialize();

    abstract void startPlay();

    abstract void endPlay();

    //模板
    public final void play() {
        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();
    }
}
