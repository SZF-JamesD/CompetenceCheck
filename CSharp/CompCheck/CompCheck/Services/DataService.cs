using CompCheck.Interfaces;
using CompCheck.Models;
using DBLib;
using MvvmUtilities.Interfaces;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace CompCheck.Services
{
    public class DataService : IDataService
    {
        private readonly DBService _dbService;
        private readonly IDialogService _dialogService;

        public DataService(DBService dbService, IDialogService dialogService)
        {
            _dbService = dbService;
            _dialogService = dialogService;
        }

        public async Task<IEnumerable<Pet>> GetAllPetsAsync()
        {
            var sql = "select * from get_pets";
            var parameters = new Dictionary<string, object>();
            await Task.Delay(3000);
            _dialogService.ShowMessage("Loading, please wait", "Loading");
            var pets = await _dbService.GetAsync<Pet>(sql, parameters, reader =>
            {
                var petDict = new Dictionary<string, object>();
                for (int i = 0; i < reader.FieldCount; i++)
                {
                    petDict[reader.GetName(i)] = reader.IsDBNull(i) ? null : reader.GetValue(i);
                }

                return Pet.FromDict(petDict);
            });
            _dialogService.ShowMessage("Success", "Loaded");
            return pets;
        }

        public async Task<IEnumerable<Vet>> GetVetAverageAsync()
        {
            var sql = "select * from vet_average";
            var parameters = new Dictionary<string, object>();

            var vetAverages = await _dbService.GetAsync<Vet>(sql, parameters, reader =>
            {
                var vetDict = new Dictionary<string, object>();
                for (int i = 0; i < reader.FieldCount; i++)
                {
                    vetDict[reader.GetName(i)] = reader.IsDBNull(i) ? null : reader.GetValue(i);
                }

                return Vet.FromDict(vetDict);
            });

            return vetAverages;
        }

        public async Task<IEnumerable<TreatmentModel>> GetAllPetTreatmentsAsync(int petId)
        {
            var sql = "select * from pet_treatments where pet_id = @petId;";
            var parameters = new Dictionary<string, object>
            {
                {"petId", petId }
            };

            await Task.Delay(3000);
            _dialogService.ShowMessage("Loading, please wait", "Loading");

            var treatments = await _dbService.GetAsync<TreatmentModel>(sql, parameters, reader =>
            {
                var treatmentDict = new Dictionary<string, object>
                {
                    {"petId", petId }
                };
                for (int i = 0; i < reader.FieldCount; i++)
                {
                    treatmentDict[reader.GetName(i)] = reader.IsDBNull(i) ? null : reader.GetValue(i);
                }

                return TreatmentModel.FromDict(treatmentDict);
            });
            _dialogService.ShowMessage("Success", "Loaded");
            return treatments;
        }
    }
}
