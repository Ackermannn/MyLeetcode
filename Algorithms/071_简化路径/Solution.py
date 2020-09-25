class Solution:
    def simplifyPath(self, path: str) -> str:
        arr = path.split('/')
        empty_numbers = arr.count('')
        for i in range(empty_numbers):
            arr.remove('')

        ans_arr = []

        for i in arr:
            if i == '.':
                continue
            elif i == '..':
                if len(ans_arr) != 0:
                    ans_arr.pop()
            else:
                ans_arr.append(i)

        return '/' + '/'.join(ans_arr)
