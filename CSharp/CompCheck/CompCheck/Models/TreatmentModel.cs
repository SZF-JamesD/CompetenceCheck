using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CompCheck.Models
{
    public class TreatmentModel
    {
        public string Diagnosis { get; set; }
        public string Treatment { get; set; }
        public string VetName { get; set; }
        public string TreatmentDate { get; set; }

        public TreatmentModel(string diagnosis, string treatment, string vetName, string treatmentDate)
        {
            Diagnosis = diagnosis;
            Treatment = treatment;
            VetName = vetName;
            TreatmentDate = treatmentDate;
        }

        public static TreatmentModel FromDict(Dictionary<string, object> dict)
        {
            if (dict == null || dict.Count == 0) return null;

            return new TreatmentModel(
                dict["diagnosis"]?.ToString(),
                dict["treatment"]?.ToString(),
                dict["vet_name"]?.ToString(),
                dict["treatment_date"]?.ToString()
                );
        }

        public override string ToString()
        {
            return $"\nDiagnosis: {Diagnosis}\nTreatment: {Treatment}\nVet: {VetName}\nTreatment Date: {TreatmentDate}";
        }
    }
}
