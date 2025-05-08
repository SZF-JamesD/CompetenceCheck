using CompCheck.Interfaces;
using CompCheck.Models;
using MvvmUtilities;
using MvvmUtilities.Interfaces;
using System.Collections.ObjectModel;
using System.Threading.Tasks;

namespace CompCheck.ViewModels
{
    public class TreatmentDetailViewModel : ViewModelBase
    {
        public ObservableCollection<TreatmentModel> Treatments { get; }
        private readonly IDataService _dataService;
        private readonly IDialogService _dialogService;

        public TreatmentDetailViewModel(IDataService dataService, IDialogService dialogService)
        {
            _dataService = dataService;
            _dialogService = dialogService;
            Treatments = new ObservableCollection<TreatmentModel>();
        }

        public async Task LoadTreatmentsForPet(int petId)
        {
            var treatments = await _dataService.GetAllPetTreatmentsAsync(petId);
            Treatments.Clear();
            foreach (var treatment in treatments)
                Treatments.Add(treatment);
        }
    }
}
