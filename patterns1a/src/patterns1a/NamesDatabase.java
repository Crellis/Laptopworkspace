package patterns1a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NamesDatabase {
	
	private List<String> names = new ArrayList<String>();
	private SortMethod sortMethod = SortMethod.QUICK_SORT;
	
	public void setSortMethod(SortMethod sortMethod) {
		this.sortMethod = sortMethod;
	}
	
	public void addName(String name) {
		names.add(name);
	}
	
	public void sort() {
		switch (sortMethod) {
			case QUICK_SORT: 
				Collections.sort(names);
			break;
			case MERGE_SORT:
				String[] namesArray = names.toArray(new String[]{});
				MergeSort.mergeSort(namesArray);
				names = Arrays.asList(namesArray);
			break;							
		}
	}

	public List<String> getNames() {
		return names;
	}

}
