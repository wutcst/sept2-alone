package Game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Character.Player;
import GUI.GUI;

/**
 * 这个类是游戏类扩展到AGame
 * @author duoduo
 *
 */
public class Game extends AGame
{
    public Game()
    {
    	super(new ZuulCommands.CommandWords());
    }
	
    /**
     * 创建房间
     * 连接房间
     **/
    @Override
    protected void createRooms()
    {
        Room outside, theatre, pub, lab, office;
        Room cafe, garden, store, restaurant, toilet,TProom;
        this._rooms = new ArrayList<>();

        // 创建房间，房间共11个
        outside = new Room(Game._messages.getString("outside"));
        this._rooms.add(outside);
        theatre = new Room(Game._messages.getString("lecture"));
        this._rooms.add(theatre);
        pub = new Room(Game._messages.getString("pub"));
        this._rooms.add(pub);
        lab = new Room(Game._messages.getString("lab"));
        this._rooms.add(lab);
        office = new Room(Game._messages.getString("admin"));
        this._rooms.add(office);
        cafe = new Room(Game._messages.getString("cafe"));
        this._rooms.add(cafe);
        garden = new Room(Game._messages.getString("garden"));
        this._rooms.add(garden);
        store = new Room(Game._messages.getString("store"));
        this._rooms.add(store);
        restaurant = new Room(Game._messages.getString("restaurant"));
        this._rooms.add(restaurant);
        toilet = new Room(Game._messages.getString("toilet"));
        this._rooms.add(toilet);
        TProom = new Room(Game._messages.getString("TProom"));
        this._rooms.add(TProom);
       
        // 设计一个游戏地图并且以该地图来构建房间链接关系以及在房间里放置对应的物品（包含物品名称和物品重量）
        outside.setExits(garden, theatre, lab, pub);
        outside.addItem(Game._messages.getString("notebook"), 2);
        theatre.setExits(TProom, cafe, null, outside);
        theatre.addItem(Game._messages.getString("rock"), 2);
        pub.setExits(null, outside, restaurant, null);
        pub.addItem(Game._messages.getString("beer"), 2);
        lab.setExits(outside, office, store, restaurant);
        lab.addItem(Game._messages.getString("laptop"), 5);
        office.setExits(null, null, null, lab);
        office.addItem(Game._messages.getString("pen"), 1);
        
        cafe.setExits(null, null, null, theatre);
        cafe.addItem(Game._messages.getString("cafe"), 1);
        cafe.addItem(Game._messages.getString("tea"), 1);
        garden.setExits(null, null, outside, null);
        garden.addItem(Game._messages.getString("stick"), 2);
        garden.addItem(Game._messages.getString("rabbit"), 1);
        store.setExits(lab, null, null, toilet);
        store.addItem(Game._messages.getString("candy"), 1);
        restaurant.setExits(pub, lab, toilet, null);
        restaurant.addItem(Game._messages.getString("food"), 2);
        toilet.setExits(restaurant, store, null, null);
        toilet.addItem(Game._messages.getString("paper"), 1);
        TProom.setExits(pub,office,store,cafe);
        //设置出现在房间里的角色信息
        lab.addCharacter(new Player(Game._messages.getString("Gandalf"), lab));
        pub.addCharacter(new Player(Game._messages.getString("Aragorn"), pub));
        toilet.addCharacter(new Player(Game._messages.getString("Legolas"), toilet));
        garden.addCharacter(new Player(Game._messages.getString("Gimly"), garden));
        cafe.addCharacter(new Player(Game._messages.getString("Frodo"), cafe));
        cafe.addCharacter(new Player(Game._messages.getString("Sam"), cafe));
        setRooms(this._rooms);
        this._player = new Player(Game._messages.getString("me"), outside);
        setPlayer(this._player);
    }
    
    /**
     * get the welcome strings
     */
    @Override
    protected List<String> getWelcomeStrings()
    {
    	List<String> rv = new LinkedList<>();
    	rv.add("");
    	rv.add(Game._messages.getString("welcome"));
    	rv.add(Game._messages.getString("zuul")); 
    	rv.add(Game._messages.getString("getHelp"));
    	rv.add("");
    	rv.addAll(getPlayer().getDetails());
    	return rv;
    }
}