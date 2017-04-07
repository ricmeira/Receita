class ChangeColumnTypeName < ActiveRecord::Migration[5.0]
  def change
    rename_column :items, :type, :itemType
  end
end
