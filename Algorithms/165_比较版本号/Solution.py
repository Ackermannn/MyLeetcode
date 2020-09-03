class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        version1_split = version1.split(".")
        version2_split = version2.split(".")
        for i in range(4):

            if i < len(version1_split):
                v1 = int(version1_split[i])
            else:
                v1 = 0

            if i < len(version2_split):
                v2 = int(version2_split[i])
            else:
                v2 = 0

            if v1 > v2:
                return 1
            elif v1 < v2:
                return -1

        return 0


if __name__ == '__main__':
    versions = [
        ["0.1", "1.1"],
        ["1.0.1", "1"],
        ["7.5.2.4", "7.5.3"],
        ["1.01", "1.001"],
        ["1.0", "1.0.0"]
    ]
    sol = Solution()
    for v in versions:
        print(sol.compareVersion(v[0], v[1]))
