# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def zigzagLevelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return []
        list1=[]
        list2=[]
        reverse=False
        curlist=list1
        nextlist=list2
        curlist.append(root)
        outerlist=[]
        while(len(curlist)!=0):
            innerlist=[x.val for x in curlist]
            outerlist.append(innerlist if not reverse else list(reversed(innerlist)))
            for r in curlist:
                if r.left:
                    nextlist.append(r.left)
                if r.right:
                    nextlist.append(r.right)
            reverse=not reverse
            curlist=nextlist
            nextlist=[]
        return outerlist

if __name__ == '__main__':
    root=TreeNode(3)
    root.left=TreeNode(9)
    root.right=TreeNode(20)
    root.right.left=TreeNode(15)
    root.right.right=TreeNode(7)
    print(Solution().zigzagLevelOrder(root))
    list(set())