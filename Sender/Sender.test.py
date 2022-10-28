import unittest
from Sender import Solution

class TypewiseTest(unittest.TestCase):
  def Test_Sensor_data_generator(self):
    test_sample = []
    test_sample = Solution.Sensor_data_generator(10,0,50)
    self.assertTrue(len(test_sample)==10)
  
  def Test_fetch_data_from_sensors(self):
    test_data = Solution.fetch_data_from_sensors(10)
    self.assertTrue(len(test_data)==2)
    self.assertTrue(len(test_data[0])==len(test_data[1])==10)
  
  def Test_format_data_in_JSON(self):
    test_data_in_JSON = Solution.format_data_in_JSON(1,"Temperature",45,"SOC",80)
    self.assertTrue(test_data_in_JSON == "{Sample_no:1, Temperature:45, SOC:80}")

if __name__ == '__main__':
    unittest.main()