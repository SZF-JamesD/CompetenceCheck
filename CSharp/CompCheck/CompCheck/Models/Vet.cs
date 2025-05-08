using System;
using System.Collections.Generic;

namespace CompCheck.Models
{
    public class Vet
    {
        public string VetName { get; set; }
        public decimal AverageCost { get; set; }

        public Vet(string vetName, decimal averageCost)
        {
            VetName = vetName;
            AverageCost = averageCost;
        }

        public static Vet FromDict(Dictionary<string, object> dict)
        {
            if (dict == null || dict.Count == 0) return null;

            return new Vet(
                dict["vet_name"]?.ToString(),
                Convert.ToDecimal(dict["average_cost"])
                );
        }

        public override string ToString()
        {
            return string.Format("Vet: {0, -20} Average Cost: {1, 10}", VetName, AverageCost);
        }
    }
}
