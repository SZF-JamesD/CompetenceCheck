using CompCheck.Interfaces;
using CompCheck.Views;
using Microsoft.Extensions.DependencyInjection;
using MvvmUtilities;
using MvvmUtilities.Interfaces;

namespace CompCheck.ViewModels
{
    public class MainWindowViewModel : ViewModelBase
    {
        private readonly IDataService _dataService;
        private readonly IDialogService _dialogService;
        private object _currentView;

        public object CurrentView
        {
            get => _currentView;
            set => SetProperty(ref _currentView, value);
        }

        public MainWindowViewModel(IDialogService dialogService, IDataService dataServíce)
        {
            _dialogService = dialogService;
            _dataService = dataServíce;

            var mainVM = App.ServiceProvider.GetRequiredService<MainViewModel>();


            var mainView = App.ServiceProvider.GetRequiredService<MainView>();
            mainView.DataContext = mainVM;
            CurrentView = mainView;
        }
    }
}
