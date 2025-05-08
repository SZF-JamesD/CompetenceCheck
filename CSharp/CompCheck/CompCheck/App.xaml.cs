using CompCheck.Interfaces;
using CompCheck.Models;
using CompCheck.Services;
using CompCheck.ViewModels;
using CompCheck.Views;
using DBLib;
using Microsoft.Extensions.DependencyInjection;
using MvvmUtilities;
using MvvmUtilities.Interfaces;
using System;
using System.Collections.ObjectModel;
using System.Data.Common;
using System.Windows;

namespace CompCheck
{
    public partial class App : Application
    {

        public static IServiceProvider ServiceProvider { get; private set; }

        protected override void OnStartup(StartupEventArgs e)
        {
            var serviceCollection = new ServiceCollection();

            ConfigureServices(serviceCollection);

            ServiceProvider = serviceCollection.BuildServiceProvider();

            var mainWindowViewModel = ServiceProvider.GetRequiredService<MainWindowViewModel>();
            var mainWindow = ServiceProvider.GetRequiredService<MainWindow>();

            mainWindow.DataContext = mainWindowViewModel;
            mainWindow.Show();

            base.OnStartup(e);
        }

        public void ConfigureServices(IServiceCollection services)
        {
            services.AddTransient<Func<DbConnection>>(_ => () => DBConnection.GetConnection());
            services.AddTransient<DBService>();

            services.AddSingleton<IDialogService, DialogService>();
            services.AddSingleton<IDataService, DataService>();

            services.AddSingleton<ObservableCollection<Pet>>();
            services.AddSingleton<ObservableCollection<Vet>>();
            services.AddSingleton<ObservableCollection<TreatmentModel>>();

            services.AddSingleton<MainWindowViewModel>();
            services.AddSingleton<MainViewModel>();
            services.AddTransient<TreatmentDetailViewModel>();

            services.AddSingleton<MainWindow>();
            services.AddSingleton<MainView>();
            services.AddTransient<TreatmentDetailView>();
        }

    
    }
       
    
}
