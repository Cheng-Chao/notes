## 算法思想：
计算字符串f每一个位置之前的字符串的前缀和后缀公共部分的最大长度（不包括字符串本身，否则最大长度始终是字符串本身）。获得f每一个位置的最大公共长度之后，就可以利用该最大公共长度快速和字符串O比较。当每次比较到两个字符串的字符不同时，我们就可以根据最大公共长度将字符串f向前移动(已匹配长度-最大公共长度)位，接着继续比较下一个位置。事实上，字符串f的前移只是概念上的前移，只要我们在比较的时候从最大公共长度之后比较f和O即可达到字符串f前移的目的。

![kmp](http://img.blog.csdn.net/20130924000843031)


理解了kmp算法的基本原理，下一步就是要获得字符串f每一个位置的最大公共长度。这个最大公共长度在算法导论里面被记为next数组。在这里要注意一点，next数组表示的是长度，下标从1开始；但是在遍历原字符串时，下标还是从0开始。假设我们现在已经求得next[1]、next[2]、……next[i]，分别表示长度为1到i的字符串的前缀和后缀最大公共长度，现在要求next[i+1]。由上图我们可以看到，如果位置i和位置next[i]处的两个字符相同（下标从零开始），则next[i+1]等于next[i]加1。如果两个位置的字符不相同，我们可以将长度为next[i]的字符串继续分割，获得其最大公共长度next[next[i]]，然后再和位置i的字符比较。这是因为长度为next[i]前缀和后缀都可以分割成上部的构造，如果位置next[next[i]]和位置i的字符相同，则next[i+1]就等于next[next[i]]加1。如果不相等，就可以继续分割长度为next[next[i]]的字符串，直到字符串长度为0为止。

### 普通的字符串匹配算法



	public static int sinple_find_sub_palin(int pos, String origin, String target) {

		for (int i = pos; i < origin.length(); i++) {
			int j = 0;
			System.out.println("i = " + i);
			while (j < target.length() && i + j < origin.length()) {

				if (origin.charAt(i + j) == target.charAt(j)) {
					j++;

				} else {
					break;
				}
				if (j == target.length())
					return i;
			}

		}
		return -1;
	}

