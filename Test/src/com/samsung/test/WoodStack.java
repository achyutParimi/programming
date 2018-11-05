package com.samsung.test;

public class WoodStack {
	
	static int blocks[][];
	int relationTable[][];
	boolean blockUsing[];
	int MaxBlocks;
	int MaxStack;
/*	
	void readData()
	{
		int i;
		scanf("%d", &MaxBlocks);
		for (i = 0; i < MaxBlocks; i++) {
			scanf("%d %d", &blocks[i][0], &blocks[i][1]);
		}

		while (blocks[i][0] > 0) {
			blocks[i][0] = 0;
			blocks[i][1] = 1;
			i++;
		}

		return;
	}

	int isBigger(int source, int target)
	{
		if ((blocks[source][0] <= blocks[target][0] && blocks[source][1] <= blocks[target][1])
			|| (blocks[source][1] <= blocks[target][0] && blocks[source][0] <= blocks[target][1])) return 1;
		else return 0;
	}

	void makeRelationshipTable()
	{

		int s, t;
		for (s = 0; s < MaxBlocks; s++) {
			//t = 0;
			//while (t <= s) {
			// relationTable[s][t] = 0;
			// t++;
			//}
			for (t = 0; t < MaxBlocks; t++) {
				if (s != t) relationTable[s][t] = isBigger(s, t);
			}
		}
	}

	bool useBlock(int blockNumber, bool isSet)
	{
		if (isSet && !blockUsing[blockNumber]) {
			blockUsing[blockNumber] = true;
			return 1;
		}
		else if (!isSet && blockUsing[blockNumber]) {
			blockUsing[blockNumber] = false;
			return 1;
		}
		else return 0;
	}

	void initialize()
	{
		MaxStack = 0;

		int s, t;
		//for (s = 0; s < MaxBlocks; s++) {
		//	t = 0;
		//	while (t <= s) {
		//		relationTable[s][t] = 0;
		//		t++;
		//	}
		//}
	}

	void doStack(int source, int depth)
	{
		int temp;
		if (DEBUG) {
			for (temp = 0; temp < depth - 1; temp++) printf("            ");
			printf("%d:", depth);
			printf("(%3d,%3d)", blocks[source][0], blocks[source][1]);
		}

		if (!useBlock(source, 1)) {
			printf("block Marking error!!! at (%3d,%3d)\n", source, depth);
		}
		int target;

		if (depth > MaxStack) {
			MaxStack = depth;
			if (DEBUG) {
				printf(" <-- Max Value\n");
			}
		}
		else { if (DEBUG) printf("\n"); }

		for (target = 0; target < MaxBlocks; target++) {
			if (source != target && relationTable[source][target] && !blockUsing[target]) doStack(target, depth + 1);
		}

		if (!useBlock(source, 0)) {
			printf("block unmarking error!!! at (%3d,%3d)\n", blocks[source][0], blocks[source][1]);
		};
	}
	public static void main(){
		
	}
*/
}
