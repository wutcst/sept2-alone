package Item;

/**
 * 这个类是对Item类制定的接口
 * @author duoduo
 *
 */
public interface IItem
{
	public String getItemName();//返回物品的名称。实现类应该提供这个方法来获取物品的名称。
    public int getWeight();//返回物品的重量。实现类应该提供这个方法来获取物品的重量。
    public void print();//打印物品的信息。实现类应该提供这个方法来自定义物品信息的打印方式。
}
    	if (name != null)
    		this._characters.remove(name);
    }
    /**
     * 判断是否有角色
     */
    public boolean hasCharacter(String character)
    {
    	return this._characters.containsKey(character);
    }
    /**
     * 哈希表中的角色
     */
    public HashMap<String, Player> getListCharacters()
    {
    	return this._characters;
    }
    /**
     * 物品和角色的详细信息
     */
    public List<String> getDetails()
    {   	
    	List<String> details = new LinkedList<>();
    	
    	details.add(AGame._messages.getString("in") + " " + getDescription());
        String tmp = AGame._messages.getString("exits") + ": ";
        tmp = this._exits.keySet().stream()
                .map((dir) -> dir + ' ')
                .reduce(tmp, String::concat);
        details.add(tmp);
        
        tmp = AGame._messages.getString("items") + ": ";
        tmp = this._itemsPresent.keySet().stream()
                .map((desc) -> desc + '(' + this._itemsPresent.get(desc).getWeight() + ')')
                .reduce(tmp, String::concat);
        details.add(tmp);
        
        tmp = AGame._messages.getString("characters") + ": ";
        tmp = this._characters.keySet().stream()
        		.map((desc) -> desc + ' ')
        		.reduce(tmp, String::concat);    
        details.add(tmp);
        
        return details;
    }
}