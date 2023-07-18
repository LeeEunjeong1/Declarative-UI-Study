//
//  TabBarButton.swift
//  iOS
//
//  Created by 김지현 on 2023/07/17.
//

import SwiftUI

struct TabBarButton: View {
	let text: String
	@Binding var isSelected: Bool
	
	var body: some View {
		Text(text)
			.fontWeight(isSelected ? .black : .regular)
			.font(.system(size: 16))
			.padding(10)
			.overlay(
				Rectangle()
					.frame(height: 4)
					.foregroundColor(isSelected ? .black : .clear),
				alignment: .bottom
			)
	}
}

//struct TabBarButton_Previews: PreviewProvider {
//	static var previews: some View {
//		TabBarButton(text: <#T##String#>, isSelected: <#T##Binding<Bool>#>)
//	}
//}
