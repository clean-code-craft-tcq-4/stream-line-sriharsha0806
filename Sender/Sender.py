from typing import List
import random 

class Solution:
    def Simulator(self, samples : int, extremes: List[int]) -> List[int]:
        Sensor_Samples = []
        for i in range(samples):    
            Sensor_Samples.append(random.randint(extremes[0], extremes[1]))
        return Sensor_Samples

    def fetch_data(self, number_of_samples):
        Data_Soc_Sensor = self.Simulator(number_of_samples, [0, 100])
        Data_Temp_Sensor = self.Simulator(number_of_samples, [0, 45])
        Data_Battery_Sensor = self.Simulator(number_of_samples, [0, 90])
        return Data_Soc_Sensor, Data_Temp_Sensor, Data_Battery_Sensor

    def format_data_in_JSON(self, sample_number, Sensor_1, Sensor_1_value, Sensor_2, Sensor_2_value, Sensor_3, Sensor_3_value):
        data_in_JSON = ('{{{0}:{1}, {2}:{3}, {4}:{5}, {6}:[7]}}\n'.format("Sample_no", sample_number, Sensor_1,Sensor_1_value, Sensor_2, Sensor_2_value, Sensor_3, Sensor_3_value))
        return data_in_JSON
    
    def print_data_on_console(self, data):
        print("Data : ", data)

    def consolidate_sensor_data_on_console(self, number_of_samples):
        data_from_sensor = self.fetch_data(number_of_samples)
        for i in range(number_of_samples):
            consolidated_data = self.format_data_in_JSON(i, "SOC Sensor", data_from_sensor[0][i], \
            "Temperature Sensor", data_from_sensor[1][i], \
            "Battery Sensor", data_from_sensor[2][i]
                )
            print(consolidated_data)
            self.print_data_on_console(consolidated_data)


if __name__ == '__main__':
    number_of_samples = 50
    sol = Solution()
    sol.consolidate_sensor_data_on_console(number_of_samples)





