   M S B A M L   `   `   `  ����D  @CompCheck, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null1clr-namespace:CompCheck.ViewsCompCheck.Views  5          CompCheck.Views.MainView   5      W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5      R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5      Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5      @d2http://schemas.microsoft.com/expression/blend/2008     5      /localclr-namespace:CompCheck.Views     5      c _System.Windows.Interactivity, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35Bi:http://schemas.microsoft.com/expression/2010/interactivity  5      .��5
      � 
�������  � ColumnDefinitions  5   
   �� 5      $
��Auto �6   �� 5      $��0.35* �6    � RowDefinitions 5   
   �� 5      $
��Auto �6   �� 5      $��* �6   .+�5   
   �� $��0��6   $��0��6   $��2��6.   $ ��Vet Clinic Data Management��6B   $��24(�6g    � UseLayoutRounding .  6u   �� 5   
   $��1��6   $��1��6   $
��Pets��6-   $��10(�6<    .  6J   �� 5   
   $��1��6   $��1��6$   $��Visible=�64   $��
2, 0, 2 ,5q�6Z   .��5      �� -   5         ��Name$ PetListView��5      ��6,   �� *Pets+ �� SelectedItem 6J   �� *SelectedPet+ �� Mode$ TwoWay=�.  (System.Windows.Interactivity.Interaction   Triggers 5      /  )System.Windows.Interactivity.EventTrigger  5         	EventName$ MouseDoubleClick��6%   .  (System.Windows.Interactivity.TriggerBase   Actions. 5      6  0System.Windows.Interactivity.InvokeCommandAction  	   Command	 60   �� *ToTreatmentDetailsCommand+5      ��5!      �� 5"      .R�5#      �   5$      �� 5%   "   $��50 �63   �� 5&   "   $	��150 �63   �� 5'   "   $��50 �63   �� 5(   "   $��80 �63   �� 5)   "   $��50 �63   �� 5*   "   $
��Auto �63   .+�5-      �� $��0��6(   $��Name:��68   �� 5.      $��1��6(   ��68   �� *	PetName+�� 5/      $��2��6(   $��	Species: ��68   �� 50      $��3��6(   ��68   �� *	PetType+�� 51      $��4��6(   $��Owner: ��68   �� 52      $��5��6(   ��68   �� *	OwnerName+55      56      58      59      � 5;   
   $��1��6   $��0��6    5<      �� 5=      $
��Auto �6    �� 5>      $��0.45* �6    �� 5?      $��* �6    .+�5B      �� $��0��6   $��Average Cost Per Vet��6!   $��10(�6@    .  6N   �� 5D      $��1��6   $��Visible=�6(   $��
2, 0, 2 ,5q�6N   .��5E      �� -   5        $ VetListView��5E      ��60   �� *Vets+��5F      �� 5G      .R�5H      �� 
 �� Orientation$
 
Horizontal=�6)   .+�5I   "   � .+�5J   &   �� ��60   �� *	VetName+ �� StringFormat$ {0}, ���� 5K   &   ��60   �� *AverageCost+5L   #   5M      5N      5P      5Q      �� 5S      $��Refresh Page��6   $��10(�6,   $��Center=�6^   $��2��6|   $	��120��6�   $��25��6�   $��1,1,1,1q�6�   $��2,5,2,5q�6�   ��6;   �� *RefreshCommand+6�   5T      5X      5Y      