class Codec:
    def encode(self, strs: List[str]) -> str:
        """Encodes a list of strings to a single string.
        """
        
        # you could choose a single character but then there is no
        # guarantee that the same character is not a part of the string
        # so you could choose to encode the length of the string as part
        # of the encoded output
        # "Hello" gets encoded as 
        # 5^Hello if the character choice is ^
        res = ""

        for s in strs:
          res += str(len(s)) + "^" + s
        
        return res

    def decode(self, s: str) -> List[str]:
        """Decodes a single string to a list of strings.
        """

        # While decoding there are some steps to be carried out
        # by first looking for the number i.e. length of the string
        # followed by the encoding character i.e. ^ 
        # and then reading the numbero of characters right after the 
        # encoding character
        res, i = [], 0

        while i < len(s):
          # expect to start by a number therefore keep looking
          # for that number to be read until ^ is hit
          j = i
          while s[j] != "^":
            j += 1
          length = int(s[i:j])
          res.append(s[j + 1 : j + 1 + length]) # j + 1 because j is on the encoding char ^
          i = j + 1 + length 

        return res



        


# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(strs))
